INSERT INTO client (name) VALUES
                              ('John Doe'),
                              ('Cora McCann'),
                              ('Lachlan Colon'),
                              ('Autumn Lin'),
                              ('Eden Meadows'),
                              ('Kamilah Fuentes'),
                              ('Johan Schwartz'),
                              ('Sky O’Neal'),
                              ('Addilynn Jacobson'),
                              ('Stefan Sampson');

INSERT INTO planet (id, name) VALUES
                                  ('JUP', 'Jupiter'),
                                  ('VEN', 'VENUS'),
                                  ('MERC', 'Mercury'),
                                  ('NEPT', 'Neptune'),
                                  ('EA', 'EARTH');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
                                                                             ('2024-07-03 11:15:56', 1, 'VEN', 'EA'),
                                                                             ('2024-07-29 06:51:48', 9, 'NEPT', 'JUP'),
                                                                             ('2024-06-18 22:46:00', 7, 'MERC', 'EA'),
                                                                             ('2024-07-21 18:34:42', 4, 'VEN', 'MERC'),
                                                                             ('2024-08-17 14:29:56', 8, 'VEN', 'NEPT'),
                                                                             ('2024-07-11 01:04:24', 2, 'VEN', 'JUP'),
                                                                             ('2024-08-08 16:07:18', 3, 'JUP', 'MERC'),
                                                                             ('2024-07-29 06:18:05', 7, 'VEN', 'NEPT'),
                                                                             ('2024-07-03 11:15:56', 6, 'MERC', 'EA'),
                                                                             ('2024-07-30 22:32:55', 5, 'EA', 'JUP');
