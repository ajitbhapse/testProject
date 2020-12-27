package pojo.getSession;

import java.util.Date;

public class LoginInfo {
	 	public int loginCount;
	    public Date previousLoginTime;
		public int getLoginCount() {
			return loginCount;
		}
		public void setLoginCount(int loginCount) {
			this.loginCount = loginCount;
		}
		public Date getPreviousLoginTime() {
			return previousLoginTime;
		}
		public void setPreviousLoginTime(Date previousLoginTime) {
			this.previousLoginTime = previousLoginTime;
		}
	    
}
