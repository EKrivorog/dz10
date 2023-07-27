package cc.robotdreams.lesson16;

import cc.robotdreams.lesson16.exceptions.WrongAccountException;
import cc.robotdreams.lesson16.exceptions.WrongCurrencyException;
import cc.robotdreams.lesson16.exceptions.WrongOperationException;

public class Main {

    public static void main(String[] args) {
        BankApplication bankApplication = new BankApplication();

        processWrapper(bankApplication, "accountId000", 50, "USD");
        processWrapper(bankApplication, "accountId003", 250, "HRV");
        processWrapper(bankApplication, "accountId001", 50, "EUR");
        processWrapper(bankApplication, "accountId001", 50, "USD");
        processWrapper(bankApplication, "accountId001", 2000, "USD");
    }

    public static void processWrapper(BankApplication bankApplication, String accountId, int amount, String currency) {
        try {
            bankApplication.process(accountId, amount, currency);
            System.out.println("Операція успішно виконана");
        } catch (WrongAccountException e) {
            System.out.println("Такого акаунту не існує");
        } catch (WrongCurrencyException e) {
            System.out.println("Акаунт має рахунок в іншій валюті");
        } catch (WrongOperationException e) {
            System.out.println("Акаунт не має достатньо коштів");
        } catch (Exception e) {
            System.out.println("Сталася помилка при процесінгу, спробуйте ще раз");
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
        }
    }
}