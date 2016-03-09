package org.caringbridge.services.journals.repository;

import static org.junit.Assert.assertNotNull;

import org.caringbridge.services.journals.CbApplication;
import org.caringbridge.services.journals.config.BaseDbTest;
import org.caringbridge.services.journals.model.Journal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CbApplication.class)
@WebAppConfiguration
public class JournalRepositoryTest extends BaseDbTest {
    @Autowired
    private JournalRepository journalRepo;
    
    @Test
    public void test() {
	assertNotNull(journalRepo);
	Pageable pr = new PageRequest(0, 10);
	Page<Journal> journals = journalRepo.findByIsDeletedAndIsDraft("1", "1", pr);
	assertNotNull(journals);
    }

}
