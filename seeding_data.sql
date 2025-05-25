DECLARE
  v_hotel_id    NUMBER;
  v_dp_id       NUMBER;
  v_room_count  NUMBER;
  v_cus_id      NUMBER;
  v_ph_id       NUMBER;
BEGIN
  -- Khởi tạo ID tiếp theo cho DATPHONG
  SELECT NVL(MAX(ID),0) + 1
    INTO v_dp_id
    FROM DATPHONG;  -- DATPHONG định nghĩa theo booking_app_khachsan.sql :contentReference[oaicite:0]{index=0}

  -- 1. Tạo 10 khách hàng
  FOR i IN 1..10 LOOP
    INSERT INTO NGUOIDUNG(EMAIL, MATKHAU, HOTEN, LOAITK)
      VALUES(
        'customer' || LPAD(i,2,'0') || '@example.com',
        'pass'     || LPAD(i,2,'0'),
        'Khách Hàng ' || i,
        'KHACHHANG'
      );
    INSERT INTO KHACHHANG(ID, CCCD, NGAYSINH)
      VALUES(
        SEQ_NGUOIDUNG_ID.CURRVAL,
        LPAD(TO_CHAR(900000000000 + i),12,'0'),
        TRUNC(ADD_MONTHS(SYSDATE, -12*(20 + MOD(i,10))))
      );
  END LOOP;

  -- 2. Tạo 5 khách sạn, mỗi KS 1–10 phòng
  FOR j IN 1..5 LOOP
    INSERT INTO NGUOIDUNG(EMAIL, MATKHAU, HOTEN, LOAITK)
      VALUES(
        'hotel'   || LPAD(j,2,'0') || '@example.com',
        'hspass'  || LPAD(j,2,'0'),
        'Khách Sạn ' || j,
        'KHACHSAN'
      );
    v_hotel_id := SEQ_NGUOIDUNG_ID.CURRVAL;

    INSERT INTO KHACHSAN(ID, TENDN, DIACHI, MOTA)
      VALUES(
        v_hotel_id,
        'Hotel ' || j,
        'Địa chỉ khách sạn ' || j,
        'Mô tả khách sạn ' || j
      );

    v_room_count := TRUNC(DBMS_RANDOM.VALUE(1,10));
    FOR k IN 1..v_room_count LOOP
      INSERT INTO PHONG(
        KHACHSAN_ID, LOAIPHONG,
        GIA, MOTA, SOLUONGCONLAI, TONGSOLUONG, NGAY_DANG
      ) VALUES (
        v_hotel_id,
        CASE WHEN MOD(k,2)=0 THEN 'DELUXE' ELSE 'STANDARD' END,
        500000 + k * 50000,
        'Mô tả phòng ' || k,
        5,
        5,
        SYSDATE - DBMS_RANDOM.VALUE(0,30)
      );
    END LOOP;
  END LOOP;

  -- 3. Tạo 50 đơn đặt phòng ngẫu nhiên
  FOR x IN 1..50 LOOP
    -- Chọn khách hàng và phòng ngẫu nhiên
    SELECT ID INTO v_cus_id
      FROM (
        SELECT ID FROM NGUOIDUNG
         WHERE LOAITK = 'KHACHHANG'
         ORDER BY DBMS_RANDOM.VALUE
      )
     WHERE ROWNUM = 1;

    SELECT ID INTO v_ph_id
      FROM (
        SELECT ID FROM PHONG
         ORDER BY DBMS_RANDOM.VALUE
      )
     WHERE ROWNUM = 1;

    INSERT INTO DATPHONG(
      ID, KHACHHANG_ID, PHONG_ID,
      NGAYNHAN, SONGAY, TRANGTHAI, NGAY_DAT
    ) VALUES (
      v_dp_id,
      v_cus_id,
      v_ph_id,
      TRUNC(SYSDATE + DBMS_RANDOM.VALUE(1,30)),
      TRUNC(DBMS_RANDOM.VALUE(1,7)),
      'CHOTHANHTOAN',
      SYSDATE - DBMS_RANDOM.VALUE(0,30)
    );

    v_dp_id := v_dp_id + 1;
  END LOOP;

  COMMIT;
END;
/
