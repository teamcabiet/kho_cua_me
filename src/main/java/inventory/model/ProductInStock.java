package inventory.model;
// Generated Jun 17, 2019 6:47:01 AM by Hibernate Tools 5.4.2.Final

import java.util.Date;

/**
 * ProductInStock generated by hbm2java
 */
public class ProductInStock implements java.io.Serializable {

	private Integer id;
	private ProductInfo productInfo;
	private Integer qty;
	private int activeLag;
	private Date createDate;
	private Date updateDate;

	public ProductInStock() {
	}

	public ProductInStock(ProductInfo productInfo, int activeLag, Date createDate, Date updateDate) {
		this.productInfo = productInfo;
		this.activeLag = activeLag;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public ProductInStock(ProductInfo productInfo, Integer qty, int activeLag, Date createDate, Date updateDate) {
		this.productInfo = productInfo;
		this.qty = qty;
		this.activeLag = activeLag;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductInfo getProductInfo() {
		return this.productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public Integer getQty() {
		return this.qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public int getActiveLag() {
		return this.activeLag;
	}

	public void setActiveLag(int activeLag) {
		this.activeLag = activeLag;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
