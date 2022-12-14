# PHÁT TRIỂN PHẦN MỀM THEO CHUẨN ITSS 
## Lab 01 - Use case diagram
> Lê Thanh Giang - 20194541

## Use case giao hàng nhanh
- Luồng sự kiện chính - Basic Flow of the event

Bước 1: Khách hàng nhập các thông tin cần thiết trong form Cập nhập thông tin giao hàng và chỉ dẫn giao hàng (nếu có) <br />
Bước 2: Khách hàng lựa chọn phương thức giao hàng nhanh <br />
Bước 3: Hệ thống kiểm tra tính hợp lệ của các thông tin mà khách hàng vừa nhập <br />
Bước 4: Hệ thống kiểm tra tính khả dụng của phương thức giao hàng mà khách hàng vừa chọn dựa trên hai yếu tố địa chỉ giao hàng và sản phẩm <br />
Bước 5: Hệ thống chuyển đến màn giao hàng nhanh <br />
Bước 6: Hệ thống yêu cầu cập nhập thông tin giao hàng nhanh bao gồm thông tin giao hàng, chỉ dẫn giao hàng và thời gian giao hàng <br />
Bước 7: Hệ thống tính các đầu tiền mà khách hàng phải thanh toán dựa vào thông tin điền ở trên <br />
Bước 8: Trên giao diện người dùng, hệ thống hiển thị các khoảng mà người dùng cần thanh toán <br />
Bước 9: Trên giao diện người dùng, hệ thống hiển thị nút "Thanh toán" cho phép người dùng thanh toán <br />

- Luồng sự kiện thay thế - Alternative flows of the event

Bước 2A: Khách hàng lựa chọn phương thức giao hàng mặc định, chuyển đến màn giao hàng mặc định <br />
Bước 3A: Hệ thống thông báo khách hàng nhập thông tin không hợp lệ hoặc thiếu thông tin, yêu cầu nhập lại <br />
Bước 4A: Hệ thống thông không báo không thể giao hàng nhanh các sản phẩm trong Cart đến địa điểm ở trên, yêu cầu người dùng lựa chọn lại cách thức giao hàng và chuyển đến màn tương ứng <br />
