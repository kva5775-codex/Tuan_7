import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham {
    private final String maHang; 
    private String tenHang;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private double gia; 

    public HangThucPham(String maHang) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được để trống!"); 
        }
        this.maHang = maHang;
    }

    public HangThucPham(String maHang, String tenHang, LocalDate ngaySanXuat, LocalDate ngayHetHan, double gia) {
        this(maHang);
        setTenHang(tenHang);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
        setGia(gia);
    }

    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty())
            throw new IllegalArgumentException("Tên hàng không được để trống!");
        this.tenHang = tenHang;
    }

    public void setGia(double gia) {
        if (gia <= 0)
            throw new IllegalArgumentException("Giá phải lớn hơn 0!"); 
        this.gia = gia;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if (ngaySanXuat != null && ngaySanXuat.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Ngày SX không được ở tương lai!"); 
        this.ngaySanXuat = ngaySanXuat;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (ngayHetHan != null && this.ngaySanXuat != null && !ngayHetHan.isAfter(this.ngaySanXuat))
            throw new IllegalArgumentException("Ngày HH phải sau ngày SX!"); 
        this.ngayHetHan = ngayHetHan;
    }

    public String getMaHang() { return maHang; } 
    public String getTenHang() { return tenHang; } 
    public LocalDate getNgaySanXuat() { return ngaySanXuat; } 
    public LocalDate getNgayHetHan() { return ngayHetHan; } 
    public double getGia() { return gia; } 

    public boolean kiemTraHetHan() {
        return LocalDate.now().isAfter(this.ngayHetHan); 
    }

    public String toString() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("| %-10s | %-20s | %-12s | %-12s | %-10.0f |", 
                maHang, tenHang, 
                (ngaySanXuat != null ? df.format(ngaySanXuat) : ""), 
                (ngayHetHan != null ? df.format(ngayHetHan) : ""), 
                gia); 
    }
}