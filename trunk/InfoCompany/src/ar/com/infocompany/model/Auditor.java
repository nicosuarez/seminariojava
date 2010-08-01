package ar.com.infocompany.model;

public class Auditor {
	
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
