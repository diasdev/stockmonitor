insert into company (company_code, company_name) values ('GOGL34','Google');
insert into company (company_code, company_name) values ('PETR4','Petrobras');

insert into account (account_email, balance) values ('joe@smith.com',5000);
insert into account (account_email, balance) values ('test@test.com', 10000);

insert into stock_account (account_email, company_code, buyingPrice, sellingPrice, stock_amount) value ('joe@smith.com', 'GOGL34', 13, 15, 0);
insert into stock_account (account_email, company_code, buyingPrice, sellingPrice, stock_amount) value ('test@test.com', 'GOGL34', 12, 15, 0);
insert into stock_account (account_email, company_code, buyingPrice, sellingPrice, stock_amount) value ('test@test.com', 'PETR4', 15, 16, 0);