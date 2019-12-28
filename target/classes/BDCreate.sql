
        CREATE TABLE public.department
        (
        id bigint NOT NULL DEFAULT nextval('department_id_seq'::regclass),
        department_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
        head_of_department character varying(255) COLLATE pg_catalog."default",
        CONSTRAINT department_pkey PRIMARY KEY (id)
        )

        TABLESPACE pg_default;

        ALTER TABLE public.department
        OWNER to root;
        ----------------------------        ----------------------------        ----------------------------
                ----------------------------        ----------------------------        ----------------------------

        CREATE TABLE public.department_lectors
(
    lector bigint NOT NULL,
    department bigint NOT NULL,
    CONSTRAINT fkbb3a6f19131cb1de FOREIGN KEY (department)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fkbb3a6f19d00dae54 FOREIGN KEY (lector)
        REFERENCES public.lector (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.department_lectors
    OWNER to root;
            ----------------------------        ----------------------------        ----------------------------
                    ----------------------------        ----------------------------        ----------------------------
CREATE TABLE public.lector
(
    id bigint NOT NULL DEFAULT nextval('lector_id_seq'::regclass),
    degree character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    salary integer,
    CONSTRAINT lector_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.lector
    OWNER to root;
            ----------------------------        ----------------------------        ----------------------------
                ----------------------------        ----------------------------        ----------------------------
CREATE SEQUENCE public.department_id_seq
    INCREMENT 1
    START 6
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.department_id_seq
    OWNER TO root;
    ----------------------------        ----------------------------        ----------------------------
                ----------------------------        ----------------------------        ----------------------------
CREATE SEQUENCE public.lector_id_seq
    INCREMENT 1
    START 6
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.lector_id_seq
    OWNER TO root;