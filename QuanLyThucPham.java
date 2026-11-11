
public class QuanLyThucPham {
    private HangThucPham[] danhSach;
    private int khaNang;
    private int soLuong; 

    public QuanLyThucPham() {
        this.khaNang = 5;
        this.danhSach = new HangThucPham[khaNang];
        this.soLuong = 0; 
    }

    private void moRongMang() {
        khaNang = khaNang * 2; 
        HangThucPham[] mangMoi = new HangThucPham[khaNang]; 
        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = danhSach[i]; 
        }
        danhSach = mangMoi; 
    } 

    public int timViTriTheoMa(String maHang) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaHang().equalsIgnoreCase(maHang)) return i; 
        }
        return -1; 
    } 

    public boolean them(HangThucPham h) {
        if (timViTriTheoMa(h.getMaHang()) != -1) {
            System.out.println("Lỗi: Mã hàng " + h.getMaHang() + " đã tồn tại!");
            return false; 
        }
        if (soLuong == khaNang) moRongMang(); 
        danhSach[soLuong++] = h; 
        return true; 
    } 

    public void hienThiDanhSach() {
        if (soLuong == 0) { System.out.println("Danh sách trống."); return; } 
        System.out.println("\n-------------------------------------------------------------------------"); 
        System.out.println("| Mã hàng    | Tên hàng             | Ngày SX      | Ngày HH      | Giá        |"); 
        System.out.println("-------------------------------------------------------------------------"); 
        for (int i = 0; i < soLuong; i++) {
            System.out.println(danhSach[i]); //[cite: 6]
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Tổng số lượng: " + soLuong + " sản phẩm."); 
    } 
}