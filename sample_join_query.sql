SELECT name, street FROM person JOIN person_address ON person_address.fk_person = person.id JOIN address ON person_address.fk_address = address.id;