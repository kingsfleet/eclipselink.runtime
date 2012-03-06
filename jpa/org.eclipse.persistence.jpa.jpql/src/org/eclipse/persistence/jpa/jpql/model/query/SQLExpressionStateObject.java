/*******************************************************************************
 * Copyright (c) 2012 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.persistence.jpa.jpql.model.query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.persistence.jpa.jpql.ExpressionTools;
import org.eclipse.persistence.jpa.jpql.model.IListChangeListener;
import org.eclipse.persistence.jpa.jpql.parser.SQLExpression;
import org.eclipse.persistence.jpa.jpql.util.iterator.CloneListIterator;
import org.eclipse.persistence.jpa.jpql.util.iterator.IterableListIterator;

import static org.eclipse.persistence.jpa.jpql.parser.AbstractExpression.*;

/**
 * This expression adds support to call a native database function.
 * <p>
 * New to EclipseLink 2.4.
 * <p>
 * <b>Note:</b> {@link IEclipseLinkStateObjectVisitor} needs to be used to traverse this state
 * object.
 *
 * <div nowrap><b>BNF:</b> <code>sql_expression ::= SQL('sql' {, sql_item}*)</code><p>
 *
 * @see SQLExpression
 *
 * @version 2.4
 * @since 2.4
 * @author James
 */
@SuppressWarnings("nls")
public class SQLExpressionStateObject extends AbstractStateObject
                                       implements ListHolderStateObject<StateObject> {

	/**
	 * The name of the native database function.
	 */
	private String sql;

	/**
	 * The list of {@link StateObject} representing the arguments to pass to the native database function.
	 */
	private List<StateObject> items;

	/**
	 * Notifies the list of arguments has changed.
	 */
	public static final String ARGUMENTS_LIST = "arguments";

	/**
	 * Notifies the function name property has changed.
	 */
	public static final String SQL_PROPERTY = "functionName";

	/**
	 * Creates a new <code>SQLExpressionStateObject</code>.
	 *
	 * @param parent The parent of this state object, which cannot be <code>null</code>
	 * @exception NullPointerException The given parent cannot be <code>null</code>
	 */
	public SQLExpressionStateObject(StateObject parent) {
		super(parent);
	}

	/**
	 * Creates a new <code>FuncExpressionStateObject</code>.
	 *
	 * @param parent The parent of this state object, which cannot be <code>null</code>
	 * @param functionName The name of the native database function
	 * @param arguments The list of {@link StateObject} representing the arguments to pass to the
	 * native database function
	 * @exception NullPointerException The given parent cannot be <code>null</code>
	 */
	public SQLExpressionStateObject(StateObject parent,
	                                 String sql,
	                                 List<? extends StateObject> arguments) {
		super(parent);
		this.sql = ExpressionTools.unquote(sql);
		this.items.addAll(parent(arguments));
	}

	/**
	 * {@inheritDoc}
	 */
	public void accept(StateObjectVisitor visitor) {
		acceptUnknownVisitor(visitor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addChildren(List<StateObject> children) {
		super.addChildren(children);
		children.addAll(items);
	}

	/**
	 * {@inheritDoc}
	 */
	public <S extends StateObject> S addItem(S item) {
		getChangeSupport().addItem(this, items, ARGUMENTS_LIST, parent(item));
		return item;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addItems(List<? extends StateObject> items) {
		getChangeSupport().addItems(this, this.items, ARGUMENTS_LIST, parent(items));
	}

	/**
	 * {@inheritDoc}
	 */
	public void addListChangeListener(String listName, IListChangeListener<StateObject> listener) {
		getChangeSupport().addListChangeListener(listName, listener);
	}

	/**
	 * Determines whether the children of this {@link StateObject} are equivalent to the children
	 * of the given one, i.e. the information of the {@link StateObject StateObjects} is the same.
	 *
	 * @param stateObject The {@link StateObject} to compare its children to this one's children
	 * @return <code>true</code> if both have equivalent children; <code>false</code> otherwise
	 */
	protected boolean areChildrenEquivalent(SQLExpressionStateObject stateObject) {

		int size = itemsSize();

		if (size != stateObject.itemsSize()) {
			return false;
		}

		for (int index = size; --index >= 0; ) {

			StateObject child1 = getItem(index);
			StateObject child2 = stateObject.getItem(index);

			if (!child1.isEquivalent(child2)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canMoveDown(StateObject item) {
		return getChangeSupport().canMoveDown(items, item);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canMoveUp(StateObject item) {
		return getChangeSupport().canMoveUp(items, item);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SQLExpression getExpression() {
		return (SQLExpression) super.getExpression();
	}

	/**
	 * Returns the SQL.
	 *
	 * @return The SQL
	 */
	public String getSQL() {
		return sql;
	}

	/**
	 * {@inheritDoc}
	 */
	public StateObject getItem(int index) {
		return items.get(index);
	}

	/**
	 * Returns the quoted SQL.
	 *
	 * @return The SQL, which is quoted
	 */
	public String getQuotedSQL() {
		return ExpressionTools.quote(sql);
	}

	/**
	 * Determines whether the SQL has been specified.
	 *
	 * @return <code>true</code> if the SQL has been specified; <code>false</code>
	 * otherwise
	 */
	public boolean hasSQL() {
		return sql != null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasItems() {
		return !items.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initialize() {
		super.initialize();
		items = new ArrayList<StateObject>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEquivalent(StateObject stateObject) {

		if (super.isEquivalent(stateObject)) {
			SQLExpressionStateObject sqlState = (SQLExpressionStateObject) stateObject;
			return ExpressionTools.valuesAreEqual(sql, sqlState.sql) &&
			       areChildrenEquivalent(sqlState);
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IterableListIterator<StateObject> items() {
		return new CloneListIterator<StateObject>(items);
	}

	/**
	 * {@inheritDoc}
	 */
	public int itemsSize() {
		return items.size();
	}

	/**
	 * {@inheritDoc}
	 */
	public StateObject moveDown(StateObject item) {
		getChangeSupport().moveDown(this, items, ARGUMENTS_LIST, item);
		return item;
	}

	/**
	 * {@inheritDoc}
	 */
	public StateObject moveUp(StateObject item) {
		getChangeSupport().moveUp(this, items, ARGUMENTS_LIST, item);
		return item;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeItem(StateObject item) {
		getChangeSupport().removeItem(this, items, ARGUMENTS_LIST, item);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeItems(Collection<StateObject> items) {
		getChangeSupport().removeItems(this, this.items, ARGUMENTS_LIST, items);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListChangeListener(String listName, IListChangeListener<StateObject> listener) {
		getChangeSupport().removeListChangeListener(listName, listener);
	}

	/**
	 * Keeps a reference of the {@link SQLExpression parsed object} object, which should only be
	 * done when this object is instantiated during the conversion of a parsed JPQL query into
	 * {@link StateObject StateObjects}.
	 *
	 * @param expression The {@link SQLExpression parsed object} representing a <code><b>SQL</b></code>
	 * expression
	 */
	public void setExpression(SQLExpression expression) {
		super.setExpression(expression);
	}

	/**
	 * Sets the unquoted SQL.
	 *
	 * @param sql The SQL, which should be unquoted
	 */
	public void setSQL(String sql) {
		String old = this.sql;
		this.sql = sql;
		firePropertyChanged(SQL_PROPERTY, old, sql);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void toTextInternal(Appendable writer) throws IOException {

		// Function name
		if (sql != null) {
			writer.append(SINGLE_QUOTE);
			writer.append(sql);
			writer.append(SINGLE_QUOTE);
		}

		if (hasItems()) {
			writer.append(COMMA);
			writer.append(SPACE);
			toStringItems(writer, items, true);
		}
	}
}