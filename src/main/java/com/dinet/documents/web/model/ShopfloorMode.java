package com.dinet.documents.web.model;

import java.util.Date;

public class ShopfloorMode {
	
	public Date trndte;
    public String subnum;
    public String prtnum;
    public String catch_qty;
    public String trnqty;
    public String fr_arecod;
    public String frstol;
    public String tostol;
    public String usr_id;
    public String first_name;
    public String last_name;
    public String oprcod;
    public String actcod;
    public String ordnum;
    public String to_subnum;
    public String lodnum;
    public String schbat;
    public String prt_fam;
    public Integer cantidad;
    
	public Date getTrndte() {
		return trndte;
	}
	public String getSubnum() {
		return subnum;
	}
	public String getPrtnum() {
		return prtnum;
	}
	public String getCatch_qty() {
		return catch_qty;
	}
	public String getTrnqty() {
		return trnqty;
	}
	public ShopfloorMode(Date trndte, String subnum, String prtnum, String catch_qty, String trnqty, String fr_arecod,
			String frstol, String tostol, String usr_id, String first_name, String last_name, String oprcod,
			String actcod, String ordnum, String to_subnum, String lodnum, String schbat, String prt_fam,
			Integer cantidad) {
		super();
		this.trndte = trndte;
		this.subnum = subnum;
		this.prtnum = prtnum;
		this.catch_qty = catch_qty;
		this.trnqty = trnqty;
		this.fr_arecod = fr_arecod;
		this.frstol = frstol;
		this.tostol = tostol;
		this.usr_id = usr_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.oprcod = oprcod;
		this.actcod = actcod;
		this.ordnum = ordnum;
		this.to_subnum = to_subnum;
		this.lodnum = lodnum;
		this.schbat = schbat;
		this.prt_fam = prt_fam;
		this.cantidad = cantidad;
	}
	public String getFr_arecod() {
		return fr_arecod;
	}
	public String getFrstol() {
		return frstol;
	}
	public String getTostol() {
		return tostol;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getOprcod() {
		return oprcod;
	}
	public String getActcod() {
		return actcod;
	}
	public String getOrdnum() {
		return ordnum;
	}
	public String getTo_subnum() {
		return to_subnum;
	}
	public String getLodnum() {
		return lodnum;
	}
	public String getSchbat() {
		return schbat;
	}
	public String getPrt_fam() {
		return prt_fam;
	}
	public Integer getCantidad() {
		return cantidad;
	}   
}
