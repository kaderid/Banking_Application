package com.kader.banking.services.impl;

@Service
@RequiredArgsConstructor
public class AdressServiceImpl implements AdressService{

    private final AdressRepository repository;
    private final ObjectsValidator<AdressDto> validator;

    @Override
    public int save(AdressDto dto){
        validator.validate(dto);
        Adress adress = AdressDto.toEntity(dto);
        return repository.save(adress).getId();
    }

    @Override
    public List<AdressDto> findAll(){
        return repository.findAll()
                .stream()
                .map(AdressDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AdressDto findById(int id){
        return repository.findById(id)
                .map(AdressDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No adress was found with the provided ID : " + id));
    }

    @Override
    public void delete(int id){

        return repository.deleteById(id);
    }
}
