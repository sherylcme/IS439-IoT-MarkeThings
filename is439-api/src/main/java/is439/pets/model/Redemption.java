package is439.pets.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Redemption {
  @Id
  public ObjectId _id;

  public int age;
  public String gender;


  public String time;
  public String campaign;
  public String code;
  public String category;
  public String voucher;
  public String status;
  public String region;


  public Redemption(ObjectId _id, String time, int age, String gender, String region, String campaign, String code, String category, String voucher, String status) {
    this._id = _id;
    this.time = time;
    this.age = age;
    this.gender = gender;
    this.region = region;
    this.campaign = campaign;
    this.code = code;
    this.category = category;
    this.voucher = voucher;
    this.status = status;
  }

  // Constructors
  public Redemption() {
  }

  // ObjectId needs to be converted to string
  
  public String get_id() { return _id.toHexString(); }
  public void set_id(ObjectId _id) { this._id = _id; }

  public String isRedemptionStatus() {
    return this.status;
  }

  public void setRedemptionStatus(String status) {
    this.status = status;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getTime() {
    return this.time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getCampaign() {
    return this.campaign;
  }

  public void setCampaign(String campaign) {
    this.campaign = campaign;
  }


  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getVoucher() {
    return this.voucher;
  }

  public void setVoucher(String voucher) {
    this.voucher = voucher;
  }

  
  public String getRegion() {
    return this.region;
  }

  public void setRegion(String region) {
    this.region = region;
  }


}