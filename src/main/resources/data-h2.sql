insert into company (company_code, company_name) values ('GOGL34','Google');
insert into company (company_code, company_name) values ('PETR4','Petrobras');
insert into company (company_code, company_name) values ('BBAS3','Banco do Brasil');

insert into account (account_email, balance) values ('joe@smith.com',5000);
insert into account (account_email, balance) values ('test@test.com', 10000);

insert into stock_account (account_email, company_code, buying_price, selling_price, stock_amount) values ('joe@smith.com', 'GOGL34', 13, 15, 0);
insert into stock_account (account_email, company_code, buying_price, selling_price, stock_amount) values ('test@test.com', 'GOGL34', 12, 15, 0);
insert into stock_account (account_email, company_code, buying_price, selling_price, stock_amount) values ('test@test.com', 'PETR4', 15, 16, 0);
insert into stock_account (account_email, company_code, buying_price, selling_price, stock_amount) values ('test@test.com', 'BBAS3', 14, 15, 0);