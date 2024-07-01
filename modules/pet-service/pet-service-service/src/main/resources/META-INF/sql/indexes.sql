create index IX_7C679B02 on DG_ANIMALGROUP (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_82F14B9 on DG_ANIMALGROUP (customerId, name[$COLUMN_LENGTH:75$]);
create index IX_60F0ED1D on DG_ANIMALGROUP (groupId);
create index IX_7473DAE1 on DG_ANIMALGROUP (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E147A5A3 on DG_ANIMALGROUP (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D028809D on DG_ANIMALTAG (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_16C9054 on DG_ANIMALTAG (customerId, name[$COLUMN_LENGTH:75$]);
create index IX_ACDBE722 on DG_ANIMALTAG (groupId);
create index IX_6DB1567C on DG_ANIMALTAG (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_27554BFE on DG_ANIMALTAG (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4A7565BB on DG_DOG (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_7B37172 on DG_DOG (customerId, name[$COLUMN_LENGTH:75$]);
create index IX_8043AC44 on DG_DOG (groupId);
create index IX_73F8379A on DG_DOG (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_157DDC9C on DG_DOG (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_464AA341 on DG_Dogs_AnimalTags (companyId);
create index IX_CCDAD800 on DG_Dogs_AnimalTags (dogId);

create index IX_91FFEFF9 on DG_PETENTRY (animalGroupId);
create index IX_AF25F1CA on DG_PETENTRY (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_40C3FB81 on DG_PETENTRY (customerId, name[$COLUMN_LENGTH:75$]);
create index IX_680ACEA3 on DG_PETENTRY (customerId, vaccine);
create index IX_2E3C8A4A on DG_PETENTRY (groupId, gender);
create index IX_1101DF3B on DG_PETENTRY (groupId, status[$COLUMN_LENGTH:75$]);
create index IX_AD08C1A9 on DG_PETENTRY (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_85F79E6B on DG_PETENTRY (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_62C0BDA3 on DG_Pets_AnimalGroups (companyId);
create index IX_A122F5C5 on DG_Pets_AnimalGroups (petId);

create index IX_6AF58CBE on DG_Pets_AnimalTags (companyId);
create index IX_F6398A60 on DG_Pets_AnimalTags (petId);