package com.flprojects.urlshortener.service.mock_repository;

import com.flprojects.urlshortener.domain.Url;
import com.flprojects.urlshortener.repository.UrlShortenerRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MockRepository implements UrlShortenerRepository {
    private List<Url> mockRepository;

    public MockRepository() {
        mockRepository = new ArrayList<>(1);
        mockRepository.add(new Url(1111L, "https://www.google.com/"));
    }

    @Override
    public List<Url> findAll() {
        return mockRepository;
    }

    @Override
    public Optional<Url> findById(Long id) {
        return mockRepository.stream()
                .filter(url -> id.equals(url.getShort_url_id()))
                .findFirst();
    }

    @Override
    public <S extends Url> S save(S entity) {
        mockRepository.add(entity);
        return entity;
    }

    @Override
    public List<Url> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Url> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Url> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Url entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Url> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Url> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Url> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Url> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Url getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Url> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Url> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Url> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Url> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Url> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Url> boolean exists(Example<S> example) {
        return false;
    }



    @Override
    public boolean existsById(Long aLong) {
        return false;
    }


}
