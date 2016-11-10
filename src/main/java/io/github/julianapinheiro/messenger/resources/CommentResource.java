package io.github.julianapinheiro.messenger.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import io.github.julianapinheiro.messenger.model.Comment;
import io.github.julianapinheiro.messenger.service.CommentService;

@Path("/")
public class CommentResource{
	
	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	@POST
	public Comment addMessage(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long id, Comment comment) {
		comment.setId(id);
		return commentService.updateComment(messageId, comment);
	}

	@DELETE
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id) {
		commentService.removeComment(messageId, id);
	}

	@GET
	public String test() {
		return "new sub resource";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("CommentId") long CommentId,
						@PathParam("commentId") long commentId) {
		return "return comment ID: " + commentId + " Comment id: " + CommentId; 
	}
}
