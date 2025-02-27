/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import ClayIcon from '@clayui/icon';
import classnames from 'classnames';
import React from 'react';
import {Handle} from 'react-flow-renderer';

import '../../../../css/main.scss';
import {nodeHandles} from '../../../util/nodeHandles';

export default function StateNode({
	data: {current = false, done = false, label},
}) {
	return (
		<>
			{nodeHandles.map((handle, index) => (
				<Handle
					id={handle.id}
					key={index}
					position={handle.position}
					style={handle.style}
					type={handle.type}
				/>
			))}

			<div
				className={classnames(
					'node state-node',
					current ? 'current-state text-white' : 'text-secondary'
				)}
			>
				<span>{label}</span>

				{current ? (
					<ClayIcon className="current-icon ml-2" symbol="live" />
				) : (
					done && (
						<ClayIcon className="done-icon ml-2" symbol="check" />
					)
				)}
			</div>
		</>
	);
}
