
INSERT INTO perfil (nome) VALUES ('ADMIN'), ('COMPRADOR'), ('APROVADOR'), ('ALMOXARIFE');

INSERT INTO perfil_permissao (perfil_id, permissao)
SELECT id, p FROM perfil, unnest(ARRAY[
                                     'USUARIO_VISUALIZAR','USUARIO_CRIAR'
                                     ]) AS p WHERE nome = 'ADMIN';