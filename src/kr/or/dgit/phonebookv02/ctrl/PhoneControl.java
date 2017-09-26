package kr.or.dgit.phonebookv02.ctrl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.JOptionPane;

import kr.or.dgit.phonebookv02.dto.Phone;

public class PhoneControl {
	private Map<String, Phone> phoneBook;

	public PhoneControl() {
		phoneBook = new HashMap<>();
	
		phoneBook.put("홍길동", new Phone("홍길동","대","010-1111-1111"));
		phoneBook.put("홍길", new Phone("홍길","서","010-2222-1111"));
		phoneBook.put("태연", new Phone("태연","울","010-3333-1111"));
	}

	@Override
	public String toString() {
		return String.format("%s", phoneBook);
	}

	public boolean insertPhone(Phone newPhone) {
		if(isExist(newPhone)){
			return false;
		}
		phoneBook.put(newPhone.getName(), newPhone);
		return true;
	}
	
	public boolean isExist(Phone newPhone){
		return phoneBook.containsKey(newPhone.getName());		
	}

	public void deletePhone(Phone delPhone) {
		if(!isExist(delPhone)){
			JOptionPane.showMessageDialog(null, delPhone.getName()+" 없는이름.");
			return;
		}
		phoneBook.remove(delPhone.getName());
		JOptionPane.showMessageDialog(null, "삭제되었습니다.");
	}
	
	public Phone searchPhone(Phone searchPhone) {
		if(!isExist(searchPhone)){		
			return null;
		}
		return phoneBook.get(searchPhone.getName());
		
	}
	
	
	
	public String showPhone() {
		StringBuilder message = new StringBuilder();
		for(Entry<String,Phone> e: phoneBook.entrySet()){
			message.append(e.getValue());
			message.append("\n");
		}
		return message.toString();
	}

	public Object[][] showPhones() {
		Object[][] datas = new Object[phoneBook.size()][];
		
		int i =0;
		for(Entry<String,Phone> e: phoneBook.entrySet()){
			
			Object[] arr = new Object[4];	//"0, 1,2,3"
			arr[0] = i+1;
			Object[] phoneArr = e.getValue().toArray();
			System.arraycopy(phoneArr, 0, arr, 1 , phoneArr.length);
			datas[i] =arr;
			
			i++;
			//System.out.println(Arrays.toString(arr));
		}
		return datas;
	}	
	
	
	
}
