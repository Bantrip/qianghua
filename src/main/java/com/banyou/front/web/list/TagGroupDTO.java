package com.banyou.front.web.list;

import java.util.List;

import com.banyou.backend.entity.Tag;
import com.banyou.backend.entity.TagGroup;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

public class TagGroupDTO {

	TagGroup group;
	List<TagDTO> tags;
	
	public static class TagDTO{
		private Tag tag;
		private boolean isChecked;
		public static TagDTO builder(Tag tag){
			TagDTO dto=new TagDTO();
			dto.tag=tag;
			return dto;
		}
		public void setChecked(boolean checked){
			this.isChecked=checked;
		}
		public boolean isChecked() {
			return isChecked;
		}
		
	}
	
}
