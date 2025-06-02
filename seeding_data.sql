CREATE OR REPLACE PROCEDURE SP_GEN_ALL_DATA_FIXED AS
  v_user_id      NUMBER;
  v_hotel_id     NUMBER;
  v_room_count   NUMBER;
  v_room_id      NUMBER;
  v_customer_id  NUMBER;
  v_cnt          NUMBER;
BEGIN
  ------------------------------------------------------------
  -- 1. TẠO 10 KHÁCH HÀNG (LOAITK = 'KHACHHANG') VÀ BẢNG KHACHHANG
  ------------------------------------------------------------
  FOR i IN 1..10 LOOP
    DECLARE
      v_email   VARCHAR2(100) := 'khachhang' || LPAD(i,2,'0') || '@example.com';
      v_pass    VARCHAR2(50)  := 'pass'     || LPAD(i,2,'0');
      v_hoten   VARCHAR2(100) := 'Khách Hàng ' || i;
    BEGIN
      -- Nếu email chưa tồn tại thì mới insert vào NGUOIDUNG
      SELECT ID INTO v_user_id
      FROM NGUOIDUNG
      WHERE EMAIL = v_email;
      -- Nếu tìm thấy, v_user_id giữ ID hiện có
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        INSERT INTO NGUOIDUNG (EMAIL, MATKHAU, HOTEN, LOAITK)
        VALUES (
          v_email,
          v_pass,
          v_hoten,
          'KHACHHANG'
        );
        v_user_id := SEQ_NGUOIDUNG_ID.CURRVAL;
    END;

    -- Kiểm tra nếu chưa có record trong KHACHHANG cho ID này thì insert
    SELECT COUNT(*) INTO v_cnt
    FROM KHACHHANG
    WHERE ID = v_user_id;
    IF v_cnt = 0 THEN
      INSERT INTO KHACHHANG (ID, CCCD, NGAYSINH)
      VALUES (
        v_user_id,
        LPAD(TO_CHAR(900000000000 + i), 12, '0'),
        TRUNC(SYSDATE) - (365 * (20 + MOD(i, 10)))
      );
    END IF;
  END LOOP;

  ------------------------------------------------------------
  -- 2. TẠO 10 KHÁCH SẠN (LOAITK = 'KHACHSAN') VÀ BẢNG KHACHSAN
  --    MỖI KS CÓ 5-10 PHÒNG
  ------------------------------------------------------------
  FOR j IN 1..10 LOOP
    DECLARE
      v_email   VARCHAR2(100) := 'hotel' || LPAD(j,2,'0') || '@example.com';
      v_pass    VARCHAR2(50)  := 'hotel' || LPAD(j,2,'0');
      v_hoten   VARCHAR2(100) := 'Khách Sạn ' || j;
    BEGIN
      -- Nếu email chưa tồn tại thì insert vào NGUOIDUNG
      SELECT ID INTO v_hotel_id
      FROM NGUOIDUNG
      WHERE EMAIL = v_email;
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        INSERT INTO NGUOIDUNG (EMAIL, MATKHAU, HOTEN, LOAITK)
        VALUES (
          v_email,
          v_pass,
          v_hoten,
          'KHACHSAN'
        );
        v_hotel_id := SEQ_NGUOIDUNG_ID.CURRVAL;
    END;

    -- Kiểm tra nếu chưa có record trong KHACHSAN cho ID này thì insert
    SELECT COUNT(*) INTO v_cnt
    FROM KHACHSAN
    WHERE ID = v_hotel_id;
    IF v_cnt = 0 THEN
      INSERT INTO KHACHSAN (ID, TENDN, DIACHI, TINH, MOTA)
      VALUES (
        v_hotel_id,
        'Hotel ' || j,
        'Địa chỉ KS ' || j || ', TP.HCM',
        'TP.HCM',
        'Mô tả Khách Sạn ' || j
      );
    END IF;

    -- Tạo 5-10 phòng ngẫu nhiên cho mỗi khách sạn
    v_room_count := TRUNC(DBMS_RANDOM.VALUE(5, 10));
    FOR k IN 1..v_room_count LOOP
      -- Không kiểm tra trùng phòng, vì mỗi PHONG tự động có ID riêng
      INSERT INTO PHONG (
        KHACHSAN_ID,
        LOAIPHONG,
        GIA,
        MOTA,
        TONGSOLUONG,
        NGAY_DANG
      ) VALUES (
        v_hotel_id,
        CASE WHEN MOD(k, 2) = 0 THEN 'DELUXE' ELSE 'STANDARD' END,
        500000 + (k * 50000),
        'Mô tả phòng ' || k || ' của KS ' || j,
        TRUNC(DBMS_RANDOM.VALUE(5, 10)),
        TRUNC(SYSDATE) - (j + k)
      );
      -- Trigger trg_phong_id sẽ tự gán PHONG.ID
    END LOOP;
  END LOOP;

  ------------------------------------------------------------
  -- 3. TẠO ĐƠN ĐẶT PHÒNG (DATPHONG) CHO MỖI KHÁCH HÀNG (20-30 ĐƠN)
  ------------------------------------------------------------
  FOR cus_rec IN (
    SELECT ID FROM KHACHHANG
  ) LOOP
    v_customer_id := cus_rec.ID;
    FOR r IN 1..TRUNC(DBMS_RANDOM.VALUE(20, 30)) LOOP
      -- Chọn một phòng ngẫu nhiên
      SELECT ID INTO v_room_id
      FROM (
        SELECT ID FROM PHONG
        ORDER BY DBMS_RANDOM.VALUE
      )
      WHERE ROWNUM = 1;

      DECLARE
        v_start     DATE := TRUNC(SYSDATE) + TRUNC(DBMS_RANDOM.VALUE(1, 30));
        v_nights    NUMBER := TRUNC(DBMS_RANDOM.VALUE(1, 5));
        v_book_date DATE := TRUNC(SYSDATE) - TRUNC(DBMS_RANDOM.VALUE(0, 10));
      BEGIN
        INSERT INTO DATPHONG (
          KHACHHANG_ID,
          PHONG_ID,
          NGAYNHAN,
          NGAY_TRA,
          NGAY_DAT,
          SL,
          DIEMDANHGIA
        ) VALUES (
          v_customer_id,
          v_room_id,
          v_start,
          v_start + v_nights,
          v_book_date,
          1,
          NULL
        );
        -- Trigger trg_datphong_bi sẽ tự gán DATPHONG.ID
      EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
          -- Bỏ qua nếu có rủi ro trùng lặp nào (mặc dù DATPHONG không có unique constraint trên email)
          NULL;
      END;
    END LOOP;
  END LOOP;

  ------------------------------------------------------------
  -- 4. TẠO 20 ĐƠN CHỈNH SỬA (DON_CHINHSUA) CHO 20 ĐƠN DATPHONG ĐẦU
  ------------------------------------------------------------
  FOR edit_rec IN (
    SELECT ID, NGAYNHAN, NGAY_TRA
    FROM (
      SELECT ID, NGAYNHAN, NGAY_TRA
      FROM DATPHONG
      ORDER BY ID
    )
    WHERE ROWNUM <= 20
  ) LOOP
    -- Chỉ insert khi chưa tồn tại chỉnh sửa cho DATPHONG_ID đó
    SELECT COUNT(*) INTO v_cnt
    FROM DON_CHINHSUA
    WHERE DATPHONG_ID = edit_rec.ID;

    IF v_cnt = 0 THEN
      INSERT INTO DON_CHINHSUA (
        DATPHONG_ID,
        NGAYNHAN_MOI,
        NGAY_TRA_MOI,
        SL_MOI,
        TRANGTHAI_DUYET,
        TRANGTHAI_THANHTOAN
      ) VALUES (
        edit_rec.ID,
        edit_rec.NGAYNHAN + 1,
        edit_rec.NGAY_TRA + 1,
        1,
        'CHỜ DUYỆT',
        'CHƯA THANH TOÁN'
      );
      -- Trigger trg_auto_id_donchinhsua sẽ tự gán DON_CHINHSUA.ID
    END IF;
  END LOOP;

  COMMIT;
END SP_GEN_ALL_DATA_FIXED;
/


BEGIN
  SP_GEN_ALL_DATA_FIXED;
END;
/