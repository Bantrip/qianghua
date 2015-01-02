package com.banyou.front.web;

import java.util.Map;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.collect.Sets;

public class JsonView extends org.springframework.web.servlet.view.json.MappingJackson2JsonView{
	public static final String CONTENT_NAME="result";
	private String errorName="exception";
	private String contentName=CONTENT_NAME;
	private String messageName="message";
	private org.slf4j.Logger log=org.slf4j.LoggerFactory.getLogger(getClass());
	@PostConstruct
	public void init(){
		super.setModelKeys(Sets.newHashSet(contentName,messageName,errorName));
		super.getObjectMapper().setSerializationInclusion(Include.NON_NULL);  
	}
	
	
	@Override
	protected Object filterModel(Map<String, Object> model) {
		Object filteredMap= super.filterModel(model);
		AjaxResponse<Object> ret=new AjaxResponse<>();
		if(filteredMap instanceof Map){
			Map item=(Map) filteredMap;
			ret.setResult(item.get(contentName));
			String message=(String) item.get(messageName);
			if(message!=null){
			ret.setMessage(String.valueOf(item.get(messageName)));
			}
			Object ex=item.get(errorName);
			if(ex!=null&& ex instanceof Exception){
				Exception e=(Exception) ex;
				log.error("out put ajax error",e);
				ret.setResult(null);
				ret.setCode(AjaxResponse.ERROR);
				ret.setMessage(e.getMessage());
			}
		}else{
			ret.setResult(filteredMap);
		}
		return ret;
	}


	
	
	
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}
	
	
	public static class AjaxResponse<T> {
		public final static int SUCCESS = 200;
		public final static int ERROR = 500;
		private int code = SUCCESS;
		private String message;
		private T result;
		private Object extInfo;
		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public T getResult() {
			return result;
		}

		public void setResult(T result) {
			this.result = result;
		}

		public Object getExtInfo() {
			return extInfo;
		}

		public void setExtInfo(Object extInfo) {
			this.extInfo = extInfo;
		}
	}

}
