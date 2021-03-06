package paingainshop.model;

import java.util.Objects;



public class CTHoaDon {
	private String MaHD;
	private String MaHH;
	private int SoLuong;
	private int DonGia;
	private int GiamGia;
        private boolean saltong;
	public CTHoaDon(String MaHD,String MaHH,int SoLuong,int DonGia,int GiamGia)
	{
		this.MaHD=MaHD;
		this.MaHH=MaHH;
		this.SoLuong=SoLuong;
		this.DonGia=DonGia;
		this.GiamGia=GiamGia;
                this.saltong=true;
		
	}
        public void setSaltong(boolean bool){
            this.saltong =bool;
        }
        public boolean getSaltong(){
            return this.saltong;
        }
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public String getMaHH() {
		return MaHH;
	}
	public void setMaHH(String maHH) {
		MaHH = maHH;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getDonGia() {
		return DonGia;
	}
	public void setDonGia(int donGia) {
		DonGia = donGia;
	}
	public int getGiamGia() {
		return GiamGia;
	}
	public void setGiamGia(int giamGia) {
		GiamGia = giamGia;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof CTHoaDon){
           CTHoaDon ct = (CTHoaDon)obj;
           if(this.getMaHD().equals(ct.getMaHD()) && this.getMaHH().equals(ct.getMaHH())){
               return true;
           }else
           {
               return false;
           }
       }else{
           return false;
       }
    }
	
}
