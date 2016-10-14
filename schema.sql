
	create table Marcas (
        marca_id int not null auto_increment,
        nombre varchar(255),
        descripcion varchar(255),        
        primary key (marca_id)
    )

	create table Publicidades (
        pub_id int not null auto_increment,
        sexo varchar(255),
        edad_min int,
        edad_max int,
        horario_min int,
        horario_max int,
        descripcion varchar(255),
        primary key (pub_id)
    )
	
    create table Ofertas (
        of_id int not null auto_increment,
        descripcion varchar(255),
        primary key (of_id)
    )
	
	create table Ubicaciones (
        ubicacion_id int not null auto_increment,
        descripcion varchar(255),
        primary key (ubicacion_id)
    )
    
    create table Camaras (
        cam_id int not null auto_increment,
        ip_dir varchar(255),
        primary key (cam_id)
    )

    create table Televisores (
        tv_id int not null auto_increment,
        ip_dir varchar(255),
        primary key (tv_id)
    )

    create table Usuarios (
        user_id int not null auto_increment,
        email varchar(255),
        nombre varchar(255),
        password varchar(255),
        primary key (user_id)
    )

	create table Cazador (
        id bigint not null auto_increment,
        nombre varchar(255),
        bosque varchar(255),
        horario varchar(255),
        primary key (id)
    )

	create table Jugador (
        id bigint not null auto_increment,
        nombre varchar(255),
        posicion varchar(255),
        edad varchar(255),
        primary key (id)
    )
    
    create table Animal (
        id bigint not null auto_increment,
        nombre varchar(255),
        color varchar(255),
        velocidad varchar(255),
        primary key (id)
    ) 
        
    alter table Jugador
        add constraint FK_qrl5f3yhd9woac409hduhpk0u 
        foreign key (cazador_id) 
        references Cazador (id)
        
    alter table Animal
        add constraint FK_qrl5f3yhd9woac409hduhpk0u 
        foreign key (jugador_id) 
        references Jugador (id)        

    alter table Camaras
        add constraint FK_qrl5f3yhd9wodli09hduhpk0u 
        foreign key (ubicacion_id) 
        references Ubicaciones (ubicacion_id)

    alter table Televisores
        add constraint FK_qnbv40mm3u2h5qscsp156gg4x 
        foreign key (cam_id) 
        references Camaras (cam_id)
        
    alter table Televisores
        add constraint FK_qnbv40mm3u2h5qscsp156gg4x 
        foreign key (ubicacion_id) 
        references Ubicaciones (ubicacion_id)
        
    alter table Publicidades
        add constraint FK_5vva6lnxptcqsb4jd77t0lfi5 
        foreign key (marca_id) 
        references Marcas (marca_id)