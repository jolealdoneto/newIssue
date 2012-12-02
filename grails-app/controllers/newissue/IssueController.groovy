package newissue
import groovyx.net.http.RESTClient
import groovy.util.slurpersupport.GPathResult
import static groovyx.net.http.ContentType.TEXT



class IssueController {
	def githubService

    def index() { }

	def create() {
		def resp = githubService.createIssue(params.title, params.desc)
		println resp
		if (!resp) {
			flash.message = "Error: Your issue submission failed =/"
			log.error("ERROR: Create issue failed.")
		} else {
			flash.message = "Thank you for submitting your issue!"
		}

		redirect(action: 'index')
	}

}
