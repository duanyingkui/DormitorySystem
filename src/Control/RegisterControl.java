package Control;


import java.util.List;

import Model.RegisterModel;
import Operation.RegisterOperation;

public class RegisterControl {

	public void add(RegisterModel regis) throws Exception {
		RegisterOperation addreg = new RegisterOperation();
		addreg.Addregisterstudent(regis);
	}

	public void update(RegisterModel regis) throws Exception {
		RegisterOperation upreg = new RegisterOperation();
		upreg.Update(regis);

	}

	public void delete(Integer account) throws Exception {
		RegisterOperation delreg = new RegisterOperation();
		delreg.Delete(account);

	}

	public List<RegisterModel> reall() throws Exception {
		RegisterOperation selreg = new RegisterOperation();
		return selreg.selectall();
	}

	public RegisterModel get(Integer account) throws Exception {
		RegisterOperation selreg = new RegisterOperation();
		return selreg.selectone(account);
	}

	public RegisterModel get(String text) {
		return null;
	}
}
