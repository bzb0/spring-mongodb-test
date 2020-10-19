/*
 * Copyright 2017-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bzb.mongodb.controller;

import com.bzb.mongodb.entity.Person;
import com.bzb.mongodb.exception.ResourceNotFoundException;
import com.bzb.mongodb.repo.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * A {@link RestController} for the 'persons' resource.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonRepository personRepository;

  @Autowired
  public PersonController(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Person savePerson(@RequestBody Person person) {
    return personRepository.save(person);
  }

  @GetMapping
  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }

  @GetMapping(value = "/{id}")
  public Person getPerson(@PathVariable String id) {
    return personRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
  }

  @PutMapping(value = "/{id}")
  public Person updatePerson(@PathVariable String id, @RequestBody Person updatedPerson) {
    Person person = personRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    person.setName(updatedPerson.getName());
    person.setEmail(updatedPerson.getEmail());
    return personRepository.save(person);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deletePerson(@PathVariable String id) {
    Person person = personRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    personRepository.delete(person);
  }
}
