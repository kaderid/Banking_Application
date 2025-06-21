package com.kader.banking.services.impl;


@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{

    private final ContactRepository repository;
    private final ObjectsValidator<ContactDto> validator;

    @Override
    public int save(ContactDto dto){
        validator.validate(dto);
        Contact contact = ContactDto.toEntity(dto);
        return repository.save(contact).getId();
    }

    @Override
    public List<ContactDto> findAll(){
        return repository.findAll()
                .stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Integer id){
        return repository.findById(id)
                .map(ContactDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No contact was found with the provided ID : " + id));
    }

    @Override
    public void delete(Integer id){

        return repository.deleteById(id);
    }
}
