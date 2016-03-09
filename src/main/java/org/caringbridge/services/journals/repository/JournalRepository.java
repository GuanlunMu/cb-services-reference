package org.caringbridge.services.journals.repository;

import java.util.Optional;

import org.caringbridge.services.journals.model.Journal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JournalRepository extends PagingAndSortingRepository<Journal, String> {
    Optional<Journal> findByJournalId(String journalId);
    Page<Journal> findByIsDeletedAndIsDraft(String isDeleted, String isDraft, Pageable page);
}
