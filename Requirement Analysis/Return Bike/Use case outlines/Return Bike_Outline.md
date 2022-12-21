# PHÁT TRIỂN PHẦN MỀM THEO CHUẨN ITSS 
## Phase 1 - Use case diagram
> Lê Thanh Giang - 20194541

## Use case Return Bike
- Luồng sự kiện chính - Basic Flow of the event

Bước 1: Người dùng ấn vào nút "Return Bike" trên màn để chuyển đến màn "Return Bike" <br />
Bước 2: Người dùng chọn một trong các dock để trả xe <br />
Bước 3: Hệ thống tính só tiền mà khách hàng phải thanh toán cho dịch vụ thuê xe  <br />
Bước 4: Hệ thống hiển thị màn hình thông tin xe cũng như số tiền mà khách hàng được hoàn trả/ phải thanh toán dự vào thời gian thuê xe <br />
Bước 5: Người dùng ấn vào nút "Xác nhận thanh toán" <br />
Bước 6: Hệ thống hiển thị màn hình thanh toán dịch vụ <br />
Bước 7: Người dùng nhập các thông tin hệ thống yêu cầu để thực hiện thanh toán dịch vụ <br />
Bước 8: Người dùng ấn nút "Thanh toán" để thực hiện thanh toán dịch vụ <br />
Bước 9: Hệ thống xử lý thông tin người dùng nhập xem đúng định dạng hay không <br />
Bước 10: Bên Interbank sẽ dựa vào thông tin người dùng nhập vào để thực hiện giao dịch <br />
Bước 11: Hệ thống lưu lại thông tin giao dịch <br />
Bước 12: Hệ thống hiển thị thông tin giao dịch <br />

- Luồng sự kiện thay thế - Alternative flows of the event

Bước 2A: Người dùng tìm kiếm các dock dựa vào công cụ lọc hệ thống cung cấp <br />
Bước 2B: Người dùng ấn nút trở về màn chính trước đó <br />
Bước 5A: Người dùng ấn nút trở về màn chính trước đó <br />
Bước 7A: Người dùng ấn nút trở về màn chính trước đó <br />
Bước 9A: Hệ thống thông báo dữ liệu người dùng nhập vào sai định dạng <br />
Bước 10A: Hệ thống thông báo dữ liệu người dùng nhập vào không thể thực hiện giao dịch được <br />
Bước 11A: Hệ thống không lưu lại thông tin giao dịch được <br />
