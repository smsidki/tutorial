package id.tutorial.entity;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditListener {
	
	@PrePersist
	private void beforeSave(Audit audit) {
		Date now = new Date();
		audit.setCreatedBy("SYSTEM");
		audit.setCreatedDate(now);
		audit.setModifiedBy("SYSTEM");
		audit.setModifiedDate(now);
	}
	
	@PreUpdate
	private void beforeUpdate(Audit audit) {
		audit.setModifiedBy("SYSTEM-UPDATE");
		audit.setModifiedDate(new Date());
	}

}
