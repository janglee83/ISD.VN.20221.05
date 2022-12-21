# PHÁT TRIỂN PHẦN MỀM THEO CHUẨN ITSS 
## Lab 01 - Use case diagram
> Phạm Thị Quỳnh Giao - 20194542

## Use case rent bike
- Luồng sự kiện chính - Basic Flow of the event

Bước 1: Người dùng ấn nút Rent bike trên màn hình  <br />
Bước 2: Hệ thống hiển thị màn hình Rent bike để người dùng nhập barcode <br />
Bước 3: Người dùng nhập barcode <br />
Bước 4: Hệ thống chuyển bar code thành rental code và tìm ra xe trong bãi bằng rental code<br />
Bước 5: Hệ thống hiển thị ra màn hình thông tin thuê xe  <br />
Bước 6: Người dùng xác nhận thông tin thuê   <br />
Bước 7: Hệ thống hiển thị màn hình thanh toán  <br />
Bước 8:  Người dùng nhập thông tin thanh toán và chọn thanh toán <br />
Bước 9: Hệ thống kiểm tra thông tin thanh toán người dùng nhập xem có đúng định dạng không. <br />
Bước 10: Interbank thực hiện thanh toán dựa vào thông tin người dùng nhập  <br />
Bước 11: Hệ thống lưu lại giao dịch và hiển thị hóa đơn trên màn hình <br/>

- Luồng sự kiện thay thế - Alternative flows of the event

Bước 4A: Nếu không tìm thấy xe hoặc không chuyển được barcode thành rental code thì hệ thống in ra thông báo barcode không hợp lệ và quay lại màn hình nhập barcode <br />
Bước 9A: Nếu thông tin thanh toán người dùng nhập không đúng định dạng hệ thống in ra thông báo và quay lại màn hình nhập thông tin thanh toán<br />
Bước 10A: Nếu thông tin thanh toán mà người dùng nhập sai hệ thống in ra thông báo thông tin thanh toán sai và quay lại màn hình nhập thông tin thanh toán<br />
Bước 10A:  Nếu số dư trong tài khoản không đủ hệ thống in ra thông báo và quay lại màn hình nhập thông tin thanh toán<br />
