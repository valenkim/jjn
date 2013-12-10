package member.dto;

public class MemberDTO {
 private String id;
 private String pass;
 private String name;
 private String email;
 private String tel;

 public MemberDTO() {
  super();
 }
 public MemberDTO(String id, String pass, String name,
   String email, String tel) {
  super();
  this.id = id;
  this.pass = pass;
  this.name = name;
  this.email = email;
  this.tel = tel;
 }
 public String getId() {
  return id;
 }
 public void setId(String id) {
  this.id = id;
 }
 public String getPass() {
  return pass;
 }
 public void setPass(String pass) {
  this.pass = pass;
 }
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }
 public String getTel() {
  return tel;
 }
 public void setTel(String tel) {
  this.tel = tel;
 } 
}
