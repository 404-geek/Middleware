package com.kapture.middleware.FormatterImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.kapture.middleware.DataInterfaces.Formatter;
import com.kapture.middleware.DataModel.Model;


@Component("NoFormatting")
@Primary
public class NoFormattingImpl implements Formatter{

	@Override
	public String formatter(String data, String label, String name) {
		// TODO Auto-generated method stub
				System.out.println("No Formatting for now...!! ");
				System.out.println(label+" "+data);
				return data;
	}
	

}
