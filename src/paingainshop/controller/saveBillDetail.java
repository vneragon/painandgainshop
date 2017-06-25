/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paingainshop.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import paingainshop.model.CTHoaDon;
import paingainshop.model.DAO.CTHoaDonDAO;
import paingainshop.model.DAO.HoaDonDAO;
import paingainshop.model.DAO.NhatKiDAO;
import paingainshop.model.service.PainAndGainService;
import paingainshop.model.HoaDon;
import paingainshop.model.HoaDonData;
import paingainshop.model.NhanVien;
import paingainshop.model.NhatKi;

/**
 *
 * @author Admin
 */
public class saveBillDetail extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        HoaDonData hoadon = (HoaDonData) session.getAttribute("hoadon");
        HoaDon hd = new HoaDon(hoadon.getMaHD(), hoadon.getNgay(), hoadon.getMaKH(), hoadon.getMaNV());
        ArrayList<CTHoaDon> list = hoadon.getItems();
        String msg = "";
        HoaDonDAO hddao = new HoaDonDAO();
        CTHoaDonDAO ctdao = new CTHoaDonDAO();
        if (list.isEmpty()) {
            msg = "Không có sản phẩm nào trong hóa đơn";
        }else if(hoadon.getMaKH().isEmpty()){
            msg ="Không có khách hàng nào được chọn";
        } else if(!list.isEmpty()) {
            try {
                hddao.insertHoaDon(hd);
             // thêm nhật kí
                
                NhanVien nv = (NhanVien)session.getAttribute("login");
                String MaNK = PainAndGainService.CreatePKey("NK", new NhatKiDAO().getLastPkey());
                Date date = new Date();
                SimpleDateFormat datefrmat = new SimpleDateFormat("yyyy-MM-dd");
                String Ngay = datefrmat.format(date);
                
                SimpleDateFormat timefrmat = new SimpleDateFormat("HH:mm:ss");
                String Gio = timefrmat.format(date);
                String ND = nv.getHoTen() +" thêm hóa đơn "+ hd.getMaHD(); 
                NhatKi nk = new NhatKi(MaNK,Ngay,Gio,ND);
                NhatKiDAO db5 = new NhatKiDAO();
                db5.insertNhatKi(nk);
                for (CTHoaDon ct : list) {
                    
                    ctdao.insertCTHoaDon(ct);
                    
                }
                session.setAttribute("hoadon", null);
                msg = "success";
            } catch (Exception ex) {
                msg = "loi: " + ex.getMessage();
            }
        }
        response.getWriter().print(msg);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
