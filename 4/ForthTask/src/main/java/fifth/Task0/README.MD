# Очередь на двусвязном списке

В этой реализации задания `InMemoryOrderQueuer` принимает реализацию `MyQueue<T>` через двусвязный список.

Объяснения структуры в `Cormen ItoA - 10.2`.

- `class LinkedList<T> implements MyQueue<T>`
	+ `LinkedList<T>.Node<T>` - собственно узел, который держит указатели на предыдущий и следующий
	+ держит указатели на узел головы и узел хвоста
		* если элементов `<= 1`, то это один и тот же узел
		* если элементов `0`, то это `null`
	+ Никакого упоминания `Order` здесь
	+ В ЯП со стат. тип должны использоваться дженерики
- функция `main`, которая создаст все экземпляры, передаст друг другу и запустит `BuffetService.runUntilDone()`