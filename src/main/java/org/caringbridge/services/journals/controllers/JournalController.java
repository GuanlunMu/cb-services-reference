package org.caringbridge.services.journals.controllers;

import java.util.Arrays;
import java.util.List;

import org.caringbridge.services.journals.rep.JournalRepresentation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(basePath = "/journals", description = "The journal resource represents a single entry in a user's journal", value = "journals")
@RequestMapping(path = "/journals")
public class JournalController {

    @RequestMapping(path = { "/", "" }, method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "", httpMethod = "GET", produces = "application/json", notes = "Returns a list of journal entries. to limit the "
            + "response body, pass the desired fields in a comma separated list as the value to the 'fields' parameter. The 'sort' "
            + "field can be use to sort by createdAt or updatedAt in ascending order 'sort=+createdAt' or descending order 'sort=-createdAt'."
            + "<br/><br/>Defaults: <ul><li>sort = -createdAt</li><li>isDeleted = false</li><li>isDraft = false</li><li>page = 1</li><li>pageSize = 10</li></ul>")
    public ResponseEntity<List<JournalRepresentation>> listJournals(
            @RequestParam(name = "isDeleted", required = false, defaultValue = "false") boolean isDeleted,
            @RequestParam(name = "isDraft", required = false, defaultValue = "false") boolean isDraft,
            @RequestParam(name = "siteId", required = false) String siteId,
            @RequestParam(name = "fields", required = false) String fields,
            @RequestParam(name = "sort", required = false, defaultValue = "-createdAt") String sort,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
	return ResponseEntity.ok(Arrays.asList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "/{id}", httpMethod = "GET", notes = "Returns a journal entry.", produces = "application/json")
    public ResponseEntity<JournalRepresentation> getJournal(@PathVariable String id) {
	return ResponseEntity.ok(new JournalRepresentation());
    }
}
