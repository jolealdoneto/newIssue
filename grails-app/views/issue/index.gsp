<html>
   <head>
      <meta name="layout" content="main"/>
      <r:require modules="bootstrap"/>
   </head>
<body>
		<div id="issue" class="modal hide fade in" style="display: none; ">  
				<form action="${createLink(controller: 'issue', action: 'create')}">
						<div class="modal-header">  
								<a class="close" data-dismiss="modal">×</a>  
								<h3>Please submit your issue</h3>  
						</div>  
						<div class="modal-body">  
								<fieldset>
										<label>Title</label>
										<input type="text" name="title" placeholder="A small title" />
										<label>Description</label>
										<textarea placeholder="A little description about your issue" name="desc"></textarea>
								</fieldset>
						</div>  
						<div class="modal-footer">  
								<button type="submit" class="btn btn-success">Submit</button>  
								<a href="#" class="btn" data-dismiss="modal">Cancel</a>  
						</div>  
				</form>
		</div>
		<p><a data-toggle="modal" href="#issue" class="btn btn-primary btn-large">Create an Issue</a></p> 
</body>
</html>
