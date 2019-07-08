package lab6_part2;

public class RewardMember extends User{
	private static int numRewardMembers = 0;
	private static int rewardNumber = 99556;
	private String memberNumber;
	
	public RewardMember() {
		super();
		memberNumber = "number unknown";
	}
	
	public RewardMember(String theName, String theGender, String thePhone, String theEmail, String thePassword, String memberNumber) {
		super(theName, theGender, thePhone, theEmail, thePassword);
		this.memberNumber = memberNumber;
	}
	
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	public String getMemberNumber() {
		return memberNumber;
	}
	
	public static int getNumRewardMembers() {
		return numRewardMembers;
	}
	
	public static void updateNumRewardMembers() {
		numRewardMembers++;
	}
	
	public static String generateRewardNumber() {
		rewardNumber++;
		return String.valueOf(rewardNumber)	;
	}
	
	@Override public String toString() {
		return super.toString() + "\nMember Number: " + memberNumber;
	}

}
