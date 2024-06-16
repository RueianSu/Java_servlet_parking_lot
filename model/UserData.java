package tw.com.parking.lot.model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class UserData {

	private Integer id;

	private String email;

	private String password;

	private String nickname;

	private Date birthDate;

	private String licensePlate;

	private Date startTime;

	private Date endTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer _id) {
		id = _id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String _email) {
		email = _email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String _nickname) {
		nickname = _nickname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date _birthDate) {
		birthDate = _birthDate;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setBirthDate(String _licensePlate) {
		licensePlate = _licensePlate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date _startTime) {
		startTime = _startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date _endTime) {
		endTime = _endTime;
	}

	public UserData(Integer id, String email, String nickname, Date birthDate, String licensePlate, Date startTime,
			Date endTime) {
		super();
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.birthDate = birthDate;
		this.licensePlate = licensePlate;
		this.startTime = startTime;
		this.endTime = endTime;
	}

}
