GRANT INSERT ON booking_app.nguoidung   TO nguoidung_user;
GRANT INSERT ON booking_app.khachhang   TO nguoidung_user;
GRANT INSERT ON booking_app.khachsan TO nguoidung_user;

GRANT INSERT
  ON booking_app.DON_CHINHSUA
  TO nguoidung_user;

GRANT DELETE
  ON booking_app.datphong
  TO nguoidung_user;

GRANT DELETE
  ON booking_app.datphong
  TO nguoidung_user;
  
GRANT DELETE
    ON booking_app.thanhtoan
    TO nguoidung_user;

GRANT SELECT, INSERT
  ON booking_app.datphong
  TO nguoidung_user;
  
GRANT SELECT, INSERT
  ON booking_app.phong
  TO nguoidung_user;
  
GRANT SELECT, INSERT
  ON booking_app.thanhtoan
  TO nguoidung_user;

GRANT CREATE SESSION TO khachsan;
GRANT all ON booking_app.phong TO khachsan;

commit