# PHÁT TRIỂN PHẦN MỀM THEO CHUẨN ITSS 
## Lab 01 - Use case diagram
> Lê Thanh Giang - 20194541

## Use case đặt hàng
- Luồng sự kiện chính - Basic Flow of the event

Bước 1: Khách hàng ấn vào icon "View Cart"/text "View Cart" để chuyển vào màn ViewCart <br />
Bước 2: Khách hàng ấn vào nút đặt hàng để thực hiện việc đặt hàng <br />
Bước 3: Hệ thống kiểm tra số lượng hàng còn bao nhiêu trong Stock hoặc độ khả dụng của mặt hàng <br />
Bước 4: Khách hàng nhập các thông tin cần thiết trong form Cập nhập thông tin giao hàng và chỉ dẫn giao hàng (nếu có) <br />
Bước 5: Khách hàng chọn một trong các phương thức giao hàng khả dụng của hệ thống: Giao hàng nhanh hoặc giao hàng mặc định  <br />
Bước 6: Hệ thống kiểm tra tính hợp lệ của các thông tin mà khách hàng vừa nhập <br />
Bước 7: Hệ thống kiểm tra tính khả dụng của phương thức giao hàng mà khách hàng vừa chọn <br />
Bước 8: Hệ thống tính các đầu tiền mà khách hàng phải thanh toán dựa vào thông tin điền ở trên <br />
Bước 9: Trên giao diện người dùng, hệ thống hiển thị các khoảng mà người dùng cần thanh toán <br />
Bước 10: Trên giao diện người dùng, hệ thống hiển thị nút "Thanh toán" cho phép người dùng thanh toán <br />

- Luồng sự kiện thay thế - Alternative flows of the event

Bước 2A: Khách hàng cập nhật sản phẩm muốn mua về số lượng, variants,... hoặc thoát vì không muốn mua nữa <br />
Bước 3A: Hệ thống thông báo tính không khả dụng của sản phẩm (Out of Stock) và yêu cầu người dùng chọn sản phẩm khác và quay lại bước 1 <br />
Bước 6A: Hệ thống thông báo khách hàng nhập thông tin không hợp lệ hoặc thiếu thông tin, yêu cầu nhập lại <br />
Bước 7A: Nếu khách hàng chọn giao hàng nhanh thì hệ thống chuyển đến chức năng giao hàng nhanh <br />
