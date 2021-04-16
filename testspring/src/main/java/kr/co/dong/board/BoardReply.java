/*
 * CREATE TABLE `scott`.`board_reply` (
  `reno` INT NOT NULL AUTO_INCREMENT,
  `rewriter` VARCHAR(45) NULL,
  `rememo` VARCHAR(45) NULL,
  `redate` DATETIME NULL,
  `bno` INT NULL,
  PRIMARY KEY (`reno`),
  INDEX `bno_idx` (`bno` ASC) VISIBLE,
  CONSTRAINT `bno`
    FOREIGN KEY (`bno`)
    REFERENCES `scott`.`board` (`bno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
 */
package kr.co.dong.board;

public class BoardReply {
	private int reno;
	private String rewriter;
	private String rememo;
	private String redate;
	private int bno;
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
	}
	public String getRewriter() {
		return rewriter;
	}
	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}
	public String getRememo() {
		return rememo;
	}
	public void setRememo(String rememo) {
		this.rememo = rememo;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	@Override
	public String toString() {
		return "BoardReply [reno=" + reno + ", rewriter=" + rewriter + ", rememo=" + rememo + ", redate=" + redate
				+ ", bno=" + bno + "]";
	}
	

}
