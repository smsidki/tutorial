package id.tutorial.rest.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageHelper {
	
	private PageHelper() {}
	
	public static boolean isEmptyOnlyOnThisPage(Page<?> page) {
		return !page.hasContent() && (page.getTotalElements() != 0) && !page.isFirst();
	}
	
	public static Pageable lastPageOf(Page<?> page) {
		return PageRequest.of(page.getTotalPages() - 1, page.getSize(), page.getSort());
	}

}
