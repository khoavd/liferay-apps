create table DG_ANIMALGROUP (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	animalGroupId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	customerId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table DG_ANIMALTAG (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	animalTagId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	customerId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	status VARCHAR(75) null,
	statusDate DATE null
);

create table DG_DOG (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	dogId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	customerId LONG,
	name VARCHAR(75) null,
	title VARCHAR(75) null,
	weight DOUBLE,
	color VARCHAR(75) null,
	status VARCHAR(75) null,
	statusDate DATE null,
	animalGroupId LONG
);

create table DG_Dogs_AnimalTags (
	companyId LONG not null,
	animalTagId LONG not null,
	dogId LONG not null,
	primary key (animalTagId, dogId)
);

create table DG_PETENTRY (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	petId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	customerId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	brief VARCHAR(75) null,
	gender INTEGER,
	vaccine BOOLEAN,
	weight DOUBLE,
	birthOfDate DATE null,
	status VARCHAR(75) null,
	statusDate DATE null,
	animalGroupId LONG
);

create table DG_Pets_AnimalGroups (
	companyId LONG not null,
	animalGroupId LONG not null,
	petId LONG not null,
	primary key (animalGroupId, petId)
);

create table DG_Pets_AnimalTags (
	companyId LONG not null,
	animalTagId LONG not null,
	petId LONG not null,
	primary key (animalTagId, petId)
);