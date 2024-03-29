package ar.com.infocompany.services;

import ar.com.infocompany.model.Comment;

public class AuditService {
	
	public Comment audit(Comment comment) {
		if (!this.isLegal(comment)) {
			this.editComment(comment);
			comment.incAbuseCount();
		}
		return comment;
	}
	
	public boolean isLegal(Comment comment) {
		return true;
	}

	public Comment editComment(Comment comment) {
		// edita el comentario y tapa nombres propios y demas
		return comment;
	}
	
}

// eof
