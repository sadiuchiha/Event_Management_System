
public class TestMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			MailUtility.sendForgetPasswordMail("sadiuchiha@gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	/*
		for(int i = 0; i < 9999; i++) {
			
			String code = ForgotPasswordFrame.generateCode();
			
			if(code.charAt(0) == '9') System.out.println(code);
		}*/	
	}

}
