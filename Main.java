import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in); 
    static QuanLyThucPham ql = new QuanLyThucPham(); 
    static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 

    public static void main(String[] args) {
        duLieuMau(); 
        int chon = -1; 
        
        do {
            menu(); 
            try { 
                chon = Integer.parseInt(sc.nextLine());  
            } catch (NumberFormatException e) { 
                System.out.println("⚠️ Vui lòng nhập số!"); 
                continue; 
            }

            switch (chon) { 
                case 1: themThucPham(); break; 
                case 2: ql.hienThiDanhSach(); break; 
               
                case 0: System.out.println("👋 Tạm biệt!"); break; 
                default: System.out.println("⚠️ Lựa chọn không hợp lệ!"); 
            }
        } while (chon != 0); 
        
        sc.close(); 
    }

    
    static void menu() {
        System.out.println("\n╔══════════ QUẢN LÝ THỰC PHẨM ══════════╗"); 
        System.out.println("║  1. Thêm thực phẩm mới                ║"); 
        System.out.println("║  2. Hiển thị danh sách                ║"); 
        System.out.println("║  0. Thoát                             ║"); 
        System.out.println("╚═══════════════════════════════════════╝"); 
        System.out.print("👉 Chọn: "); 
    }

    
    static void duLieuMau() {
        
        try {
            ql.them(new HangThucPham("TP001", "Sữa tươi Vinamilk", LocalDate.of(2026, 1, 15), LocalDate.of(2026, 2, 15), 25000)); 
            ql.them(new HangThucPham("TP002", "Bánh quy Oreo", LocalDate.of(2026, 3, 5), LocalDate.of(2026, 6, 5), 15000)); 
            ql.them(new HangThucPham("TP003", "Nước ngọt Coca", LocalDate.of(2026, 9, 20), LocalDate.of(2027, 9, 20), 12000)); 
            ql.them(new HangThucPham("TP004", "Sữa chua TH True", LocalDate.of(2026, 5, 10), LocalDate.of(2026, 5, 25), 8000)); 
            ql.them(new HangThucPham("TP005", "Bánh mì Kinh Đô", LocalDate.of(2026, 8, 1), LocalDate.of(2026, 8, 15), 20000)); 
            System.out.println("✅ Đã nạp 5 sản phẩm mẫu."); 
        } catch (Exception e) {
            System.out.println("Lỗi nạp dữ liệu mẫu: " + e.getMessage());
        }
    }

    
    static void themThucPham() {
        try {
            System.out.print("Mã hàng: "); String ma = sc.nextLine(); 
            System.out.print("Tên hàng: "); String ten = sc.nextLine(); 
            System.out.print("Ngày SX (dd/MM/yyyy): "); LocalDate sx = LocalDate.parse(sc.nextLine(), df); 
            System.out.print("Ngày HH (dd/MM/yyyy): "); LocalDate hh = LocalDate.parse(sc.nextLine(), df); 
            System.out.print("Giá: "); double gia = Double.parseDouble(sc.nextLine()); 

            HangThucPham h = new HangThucPham(ma, ten, sx, hh, gia); 
            
            if (ql.them(h)) { 
                System.out.println("✅ Thêm thành công!");
            }
        } catch (IllegalArgumentException e) {
     
            System.out.println("❌ Lỗi dữ liệu: " + e.getMessage()); 
        } catch (Exception e) {
          
            System.out.println("❌ Lỗi: Nhập sai định dạng dữ liệu!");
        }
    }
}