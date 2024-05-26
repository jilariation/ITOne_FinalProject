-- Привязка сотрудников к доскам
INSERT INTO desk_employee (id, employee_id, desk_id) VALUES
('11111111-1111-1111-1111-111111111112', '33333333-3333-3333-3333-333333333333', '11111111-1111-1111-1111-111111111111'),
('11111111-1111-1111-1111-111111111113', '44444444-4444-4444-4444-444444444444', '11111111-1111-1111-1111-111111111111'),
('11111111-1111-1111-1111-111111111114', '55555555-5555-5555-5555-555555555555', '22222222-2222-2222-2222-222222222222');

-- Привязка задач к сотрудникам
INSERT INTO task_employee (id, employee_id, task_id) VALUES
('11111111-1111-1111-1111-111111111115', '33333333-3333-3333-3333-333333333333', '99999999-9999-9999-9999-999999999999'),
('11111111-1111-1111-1111-111111111116', '33333333-3333-3333-3333-333333333333', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
('11111111-1111-1111-1111-111111111117', '44444444-4444-4444-4444-444444444444', 'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb'),
('11111111-1111-1111-1111-111111111118', '55555555-5555-5555-5555-555555555555', 'cccccccc-cccc-cccc-cccc-cccccccccccc'),
('11111111-1111-1111-1111-111111111119', '55555555-5555-5555-5555-555555555555', 'dddddddd-dddd-dddd-dddd-dddddddddddd');